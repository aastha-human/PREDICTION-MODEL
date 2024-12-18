import yfinance as yf
import pandas as pd

def download_stock_data(ticker, start_date, end_date, file_path):
    data = yf.download(ticker, start=start_date, end=end_date)
    data.to_csv(file_path)
    print(f"Data saved to {file_path}")

if __name__ == "__main__":
    download_stock_data('AAPL', '2010-01-01', '2023-12-01', '../data/stock_data.csv')


