{- |
第5章 逐次プログラム
-}
module Ch05_BookFriendRecommendations(module Ch05_BookFriendRecommendations) where

-- 5.7 コーヒーブレイク：リストのリストを処理する

data Book = Book { title :: !String, authors :: ![String] } deriving (Show, Eq)

recommendedBooks :: String -> [Book]
recommendedBooks friend =
  let scala = [Book "FP in Scala" ["Chiusano", "Bjarnason"],
               Book "Get Programming with Scala" ["Sfregola"]]
      fiction = [Book "Harry Potter" ["Rowling"],
                 Book "The Lord of the Rings" ["Tolkien"]]
  in case friend of
    "Alice" -> scala
    "Bob"   -> fiction
    _       -> []
