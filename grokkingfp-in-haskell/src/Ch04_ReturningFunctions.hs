{- |
第4章 値としての関数
-}
module Ch04_ReturningFunctions(module Ch04_ReturningFunctions) where

import qualified Ch04_PassingFunctions as PF

-- 4.41 コーヒーブレイク：関数を返す

largerThan :: Int -> (Int -> Bool)
largerThan n = (> n)

divisibleBy :: Int -> (Int -> Bool)
divisibleBy n = (== 0) . (`mod` n)

shroterThan :: Int -> (String -> Bool)
shroterThan n = (< n) . length

containsS :: Int -> (String -> Bool)
containsS moreThan = (> moreThan) . PF.numberOfS
