{- |
第3章 イミュータブルな値
-}
module Ch03_AbbreviateNames(module Ch03_AbbreviateNames) where

-- 3.15 コーヒーブレイク：イミュータブルなString API

abbreviate :: String -> String
abbreviate name = initial : ". " ++ lastName
  where
    (firstName:lastName:_) = words name
    initial = head firstName
