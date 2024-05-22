{- |
第1章 関数型プログラミングを学ぶ
-}
module Ch01_Intro(module Ch01_Intro) where

-- 1.7 コーヒーブレイク：命令型と宣言型

calculateScore :: String -> Int
calculateScore [] = 0
calculateScore (c:cs)
  | c /= 'a' = 1 + calculateScore cs
  | otherwise = calculateScore cs

wordScore :: String -> Int
wordScore = length . filter (/= 'a')

-- 1.11 実習：Scalaで関数を書く

increment :: Num a => a -> a
increment = (+ 1)

getFirstCharacter :: String -> Char
getFirstCharacter = head

wordScore' :: String -> Int
wordScore' = length
