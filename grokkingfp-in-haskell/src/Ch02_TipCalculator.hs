{- |
第2章 純粋関数
-}
module Ch02_TipCalculator(module Ch02_TipCalculator) where

-- 2.10 コーヒーブレイク：純粋関数のリファクタリング
-- 2.19 実習：Scalaで純粋関数を書く

getTipPercentage :: [String] -> Int
getTipPercentage [] = 0
getTipPercentage names
  | length names > 5 = 20
  | otherwise = 10
