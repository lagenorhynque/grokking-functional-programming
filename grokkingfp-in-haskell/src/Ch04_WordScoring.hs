{- |
第4章 値としての関数
-}
module Ch04_WordScoring(module Ch04_WordScoring) where

import           Data.List (sortOn)

-- 4.22 コーヒーブレイク：Scalaで関数を渡す

rankedWords :: (String -> Int) -> [String] -> [String]
rankedWords scoreFn = reverse . sortOn scoreFn

score :: String -> Int
score = length . filter (/= 'a')

bonus :: String -> Int
bonus word = if 'c' `elem` word then 5 else 0

penalty :: String -> Int
penalty word = if 's' `elem` word then 7 else 0
