#!/bin/bash

# Ensure Java application is compiled
if [ ! -d "./bin" ]; then
    echo "Java files are not compiled. Run setup_env.sh first."
    exit 1
fi

# Run the Java application
echo "Running Java application..."
java -cp ./bin StockPredictionApp
