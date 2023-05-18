APP_NAME = index.js
BUILD_DIR = ./build
TS_FILES = ./src/index.ts
JS_FILES = ./src/index.js

.PHONY: build

all: build run

build:
	tsc $(TS_FILES) 
	mv $(JS_FILES) $(BUILD_DIR)
	

run:
	node $(BUILD_DIR)/$(APP_NAME)