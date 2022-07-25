# binance-java-api

This sample codes are for educational purposes. Use with your own risks in production environment. 
> Always use test credentials while development.


Get your own API credentials from [Binance API Management Page](https://www.binance.com/en/my/settings/api-management)



## Examples

**Get Binance Ping**
<br>
<br>uri: /binance/ping
<br>method: GET
<br>response:
```
successful
```

<hr>

**Get Binance Server Time**
<br>
<br>uri: /binance/servertime
<br>method: GET
<br>response:
```
2022-07-25 19:37:44
```

<hr>

**Get Binance Ticker**
<br>
<br>uri: /binance/ticker?pair1=BTC&pair2=USDT
<br>method: POST
<br>response:
```
{
    "symbol": "BTCUSDT",
    "askPrice": 21900.90000000,
    "bidPrice": 21899.65000000
}
```


<hr> 

**Get Binance Account Balance**
<br>
<br>uri: /binance/account
<br>method: POST
<br>response:
```
{
    "source": "binance",
    "assets": [
        {
            "asset": "BTC",
            "amount": 0.01160428
        },
        {
            "asset": "LTC",
            "amount": 0E-8
        }
    ]
}
```
