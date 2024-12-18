import yfinance as yf
import pandas as pd

def download_stock_data(ticker, start_date, end_date, file_path):
    data = yf.download(ticker, start=start_date, end=end_date)
    data.to_csv(file_path)
    print(f"Data saved to {file_path}")

if __name__ == "__main__":
    download_stock_data('AAPL', '2010-01-01', '2023-12-01', '../data/stock_data.csv')

from sklearn.preprocessing import MinMaxScaler
import numpy as np

def preprocess_data(file_path, time_step=60):
    data = pd.read_csv(file_path, usecols=['Close'])
    scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_data = scaler.fit_transform(data)

    def create_dataset(data, time_step):
        X, y = [], []
        for i in range(len(data) - time_step - 1):
            X.append(data[i:(i + time_step), 0])
            y.append(data[i + time_step, 0])
        return np.array(X), np.array(y)

    X, y = create_dataset(scaled_data, time_step)
    return X.reshape((X.shape[0], X.shape[1], 1)), y, scaler

if __name__ == "__main__":
    preprocess_data('../data/stock_data.csv')
