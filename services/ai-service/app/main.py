from fastapi import FastAPI
from pydantic import BaseModel
from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer
import uvicorn

# 1. Create the FastAPI app object
app = FastAPI()

# 2. Initialize our sentiment analyzer
# We create one instance of it here so it's ready to be used
analyzer = SentimentIntensityAnalyzer()

# 3. Define the request "shape"
# This tells FastAPI what the incoming JSON should look like
class TextPayload(BaseModel):
    text: str

# 4. Define the response "shape"
class SentimentResponse(BaseModel):
    sentiment: str # "positive", "negative", or "neutral"
    score: float   # The compound sentiment score

# 5. Define our API endpoint
@app.post("/analyze/sentiment")
def analyze_sentiment(payload: TextPayload) -> SentimentResponse:
    """
    Analyzes the sentiment of a given text.
    Returns 'positive', 'negative', or 'neutral' and a score.
    """
    
    # Use VADER to get sentiment scores
    scores = analyzer.polarity_scores(payload.text)
    
    # The 'compound' score is a single number from -1 (most negative) to 1 (most positive)
    compound_score = scores['compound']
    
    # 6. Logic to turn the score into a simple label
    sentiment_label = "neutral"
    if compound_score >= 0.05:
        sentiment_label = "positive"
    elif compound_score <= -0.05:
        sentiment_label = "negative"
        
    return SentimentResponse(sentiment=sentiment_label, score=compound_score)

# This is a helper for running the app, though we'll use uvicorn in the terminal
# uvicorn app.main:app --reload --port 8000
# Port 8000 is to make sure not interfering with the port 3000 used by react or port 8080 used by Java
if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8000)