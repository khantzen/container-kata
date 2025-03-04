# Api Spec

This api return quote from fortune when asked

## Endpoints

Api listen on port 4567

> /api/v1/categories *List all quote categories*

```json
[
  {"title": "pets"},
  {"title": "debian"},
  {"title": "kids"},
  ...
]
```

> /api/v1/allQuotes *List all quotes in the project*

```json
{
  "category1": [
    { "text": "first quote" },
    { "text": "second quote"},
    { "text": "third quote"},
    ...
  ],
  "category2": [
    {"text": "first quote"},
    ...
  ],
  ...
}
```

> /api/v1/randomQuoteIn/:category *Return a random quote for the given category* 

```json
{
  "text": "For a man to truly understand rejection, he must first be ignored by a cat."
}
```
