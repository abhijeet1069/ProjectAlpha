APP_NAME = myApp
BUILD_DIR = ./1-introduction/bin
CPP_FILES = ./1-introduction/src/hello.cpp

APP_DEFINES:=
APP_INCLUDES:= -std=c++11
APP_LINKERS:=

all: build run

build:
	c++ $(CPP_FILES) -o $(BUILD_DIR)/$(APP_NAME) $(APP_INCLUDES) $(APP_LINKERS)

run:
	$(BUILD_DIR)/$(APP_NAME)