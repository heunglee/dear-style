SHELL := /bin/bash

BACKEND_DIR := backend
WEB_DIR := web
ANDROID_DIR := android
IOS_DIR := ios
COMPOSE_FILE ?= docker-compose.yml
PYTHON ?= python3.14
NPM ?= npm
GRADLE ?= gradle
XCODEBUILD ?= xcodebuild

.DEFAULT_GOAL := help

.PHONY: help
help: ## Show available development commands.
	@awk 'BEGIN {FS = ":.*##"; printf "\nDear Style development commands:\n\n"} /^[a-zA-Z0-9_-]+:.*##/ {printf "  %-20s %s\n", $$1, $$2}' $(MAKEFILE_LIST)
	@printf "\nExamples:\n  make backend-test\n  make web-dev\n  make ios-build\n  make check\n\n"

.PHONY: doctor
doctor: ## Check local tool availability.
	@if [ ! -x "$(BACKEND_DIR)/.venv/bin/python" ] && ! command -v $(PYTHON) >/dev/null; then echo "Missing: $(PYTHON) for backend setup"; fi
	@command -v $(NPM) >/dev/null || echo "Missing: $(NPM) for web commands"
	@command -v $(GRADLE) >/dev/null || echo "Missing: $(GRADLE) for Android builds"
	@command -v $(XCODEBUILD) >/dev/null || echo "Missing: $(XCODEBUILD) for iOS builds"
	@command -v docker >/dev/null || echo "Missing: docker for dev-up/dev-down"

.PHONY: backend-setup
backend-setup: ## Create backend venv and install backend dev dependencies.
	@cd $(BACKEND_DIR) && $(PYTHON) -m venv .venv
	@cd $(BACKEND_DIR) && .venv/bin/python -m pip install --upgrade pip
	@cd $(BACKEND_DIR) && .venv/bin/pip install -e ".[dev]"

.PHONY: backend-test
backend-test: ## Run backend pytest suite.
	@cd $(BACKEND_DIR) && .venv/bin/pytest

.PHONY: backend-lint
backend-lint: ## Run backend Ruff checks.
	@cd $(BACKEND_DIR) && .venv/bin/ruff check .

.PHONY: backend-migrate
backend-migrate: ## Apply backend Alembic migrations.
	@cd $(BACKEND_DIR) && .venv/bin/alembic upgrade head

.PHONY: backend-dev
backend-dev: ## Start backend FastAPI dev server.
	@cd $(BACKEND_DIR) && .venv/bin/uvicorn app.main:app --reload

.PHONY: web-install
web-install: ## Install web dependencies.
	@cd $(WEB_DIR) && $(NPM) install

.PHONY: web-dev
web-dev: ## Start Next.js dev server.
	@cd $(WEB_DIR) && $(NPM) run dev

.PHONY: web-lint
web-lint: ## Run web lint checks.
	@cd $(WEB_DIR) && $(NPM) run lint

.PHONY: web-typecheck
web-typecheck: ## Run web TypeScript checks.
	@cd $(WEB_DIR) && $(NPM) run typecheck

.PHONY: android-build
android-build: ## Build Android debug app.
	@cd $(ANDROID_DIR) && $(GRADLE) :app:assembleDebug

.PHONY: ios-build
ios-build: ## Build iOS simulator app into ios/build.
	@cd $(IOS_DIR) && $(XCODEBUILD) -project DearStyle.xcodeproj -scheme DearStyle -sdk iphonesimulator -configuration Debug -derivedDataPath build/DerivedData build CODE_SIGNING_ALLOWED=NO

.PHONY: test
test: backend-test ## Run available automated tests.

.PHONY: check
check: backend-test web-typecheck ios-build ## Run main checks for backend, web, and iOS.

.PHONY: dev-up
dev-up: ## Start local services from docker-compose.yml.
	@docker compose -f $(COMPOSE_FILE) up -d postgres redis

.PHONY: dev-down
dev-down: ## Stop local services from docker-compose.yml.
	@docker compose -f $(COMPOSE_FILE) down

.PHONY: dev-logs
dev-logs: ## Follow local service logs.
	@docker compose -f $(COMPOSE_FILE) logs -f
