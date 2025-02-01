#!/bin/bash

# Activate Python environment
source stock_env/bin/activate

echo "Running data preprocessing..."
python3 scripts/preprocess_data.py

echo "Training the model..."
python3 scripts/train_model.py

echo "Running predictions and generating visualization..."
python3 scripts/predict_stock.py

deactivate

echo "All tasks completed successfully."
