#!/bin/bash

# Activate Python environment
source stock_env/bin/activate

# Step 1: Preprocessing
echo "Running data preprocessing..."
python3 scripts/preprocess_data.py

# Step 2: Training
echo "Training the model..."
python3 scripts/train_model.py

# Step 3: Prediction
echo "Running predictions and generating visualization..."
python3 scripts/predict_stock.py

# Deactivate Python environment
deactivate

echo "All tasks completed successfully."
