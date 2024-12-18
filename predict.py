
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from tensorflow.keras.models import load_model
from preprocess_data import preprocess_data

def plot_predictions(data, train_predict, test_predict, scaler, time_step, train_size):
    data = scaler.inverse_transform(data)
    train_predict = scaler.inverse_transform(train_predict)
    test_predict = scaler.inverse_transform(test_predict)

    plt.figure(figsize=(14, 6))
    plt.plot(data, label='Actual Prices', color='blue')
    plt.plot(range(time_step, train_size), train_predict, label='Training Predictions', color='green')
    plt.plot(range(train_size + time_step, len(data)), test_predict, label='Test Predictions', color='red')
    plt.legend()
    plt.xlabel('Days')
    plt.ylabel('Price')
    plt.title('Stock Price Prediction')
    plt.show()

if __name__ == "__main__":
    X, y, scaler = preprocess_data('../data/stock_data.csv')
    train_size = int(len(X) * 0.8)
    X_train, X_test = X[:train_size], X[train_size:]
    
    model = load_model('../models/lstm_model.h5')
    train_predict = model.predict(X_train)
    test_predict = model.predict(X_test)
    
    plot_predictions(y.reshape(-1, 1), train_predict, test_predict, scaler, 60, train_size)
