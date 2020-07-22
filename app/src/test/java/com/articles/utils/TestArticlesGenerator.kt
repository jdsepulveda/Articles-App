package com.articles.utils

import com.articles.remote.model.Article
import com.articles.remote.model.ResponseWrapper
import com.articles.remote.model.Source

class TestArticlesGenerator {

    companion object {
        fun generateArticles(): List<Article> {
            val article1 = Article(
                Source("engadget", "Engadget"),
                "Violet Blue",
                "Twitter's Bitcoin hackers had almost limitless access",
                "On Wednesday, July 15, Twitter was the target of a very public hack attack that’s still sending shockwaves across the internet. In what is a major security breach for the company, a handful of the most-followed Twitter accounts belonging to some of the world’…",
                "https://www.engadget.com/twitter-bitcoin-scam-social-engineering-hack-access-193040357.html",
                "https://o.aolcdn.com/images/dims?resize=1200%2C630&crop=1200%2C630%2C0%2C0&quality=95&image_uri=https%3A%2F%2Fs.yimg.com%2Fos%2Fcreatr-uploaded-images%2F2020-07%2Fca68c900-c85d-11ea-b9df-6238180027a8&client=amp-blogside-v2&signature=9b0fbb183070e467429323ab75f41cbbe1c8dbc3",
                "2020-07-17T19:30:40Z",
                "Just hackers burning up 0day like it’s a fire sale\r\nImagine getting the keys to the Twitter kingdom -- access to all the account admin panels in the world. What would you do? You could grab high-valu… [+8860 chars]"
            )

            val article2 = Article(
                Source("engadget", "Engadget"),
                "Karissa Bell",
                "The FBI is investigating the Twitter Bitcoin hack",
                "The FBI has confirmed that it’s investigating the hack that compromised the accounts of Joe Biden, Elon Musk, Barack Obama, Kanye West and a number of other high-profile Twitter users. “The FBI is investigating the incident involving several Twitter account b…",
                "https://www.engadget.com/fbi-investigates-twitter-hack-crypto-scam-210819751.html",
                "https://o.aolcdn.com/images/dims?resize=1200%2C630&crop=1200%2C630%2C0%2C0&quality=95&image_uri=https%3A%2F%2Fs.yimg.com%2Fos%2Fcreatr-images%2F2020-07%2F665bf5b0-c7a7-11ea-bf77-fd38c73c45ca&client=amp-blogside-v2&signature=35fbb76051772c8531395240d32dc65ca43d8866",
                "2020-07-16T21:08:19Z",
                "Reuters had previously reported the FBI would launch an investigation into the hack.\\r\\nThe FBI inquiry is now one of multiple investigations into the incident, which has drawn scrutiny from a number o… [+966 chars]"
            )

            val article3 = Article(
                Source("engadget", "Engadget"),
                "Chris Velazco",
                "Everything we know about the Twitter Bitcoin hack",
                "Author’s note: This story was first published on 7/16/2020, and last updated on the same day. Check the Latest Updates section for the most recent developments. \\r\\n Engadget\\r\\n What happened?Early in the afternoon (Eastern time) on July 15th, a hacker -- or hac…",
                "https://www.engadget.com/everything-we-know-about-the-twitter-bitcoin-scam-hack-202447973.html",
                "https://o.aolcdn.com/images/dims?resize=1200%2C630&crop=1200%2C630%2C0%2C0&quality=95&image_uri=https%3A%2F%2Fs.yimg.com%2Fos%2Fcreatr-uploaded-images%2F2020-07%2F5a079df0-c793-11ea-8b9b-fb9d0432f01a&client=amp-blogside-v2&signature=e1b2908f5e075d2c2bbce7f11fea92868295999d",
                "2020-07-16T20:24:47Z",
                "Most of these accounts tweeted some variant of the same message: If someone were to send Bitcoin to the address specified in the tweets during a 30-minute window, the account owner would return doubl… [+3388 chars]"
            )

            return listOf(article1, article2, article3)
        }

        fun generateResponseWrapperOK() = ResponseWrapper("ok", 1234, generateArticles())
    }
}