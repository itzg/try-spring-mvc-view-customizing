
This application tries out two aspects of customizing Spring MVC view customization
- Directing requests with a particular prefix (`/greeting`) to the index.html
- Processing requests for a specific content type (`text/plain`) with a custom view

## Scenarios

Invoking
```bash
curl localhost:8080
curl localhost:8080/greeting
curl localhost:8080/greeting/human
```

Gives
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Greetings</title>
</head>
<body>

Greetings, this view works.

</body>
</html>
```

Invoking
```bash
curl -H "Accept: plain/text" localhost:8080/greeting
```

Gives
```
Some plain text for the request view '/index.html'
```

Invoking
```bash
curl localhost:8080/api/currentTime
```

Gives
```html
<html><body><h1>Whitelabel Error Page</h1><p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p><div id='created'>Wed Jan 16 16:00:26 CST 2019</div><div>There was an unexpected error (type=Not Acceptable, status=406).</div><div>Could not find acceptable representation</div></body></html>
```

Invoking
```bash
curl -H "Accept: application/json" localhost:8080/api/currentTime
```

Gives
```json
{"time":"Wed Jan 16 16:00:40 CST 2019"}
```
