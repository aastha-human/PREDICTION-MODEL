#!/bin/bash

# Step 1: Setup Python environment
echo "Setting up Python environment..."
python3 -m venv stock_env
source stock_env/bin/activate
pip install -r requirements.txt
deactivate
echo "Python environment setup complete."

# Step 2: Compile Java files
echo "Compiling Java files..."
mkdir -p bin
javac -d ./bin ./src/main/java/*.java
echo "Java compilation complete."
