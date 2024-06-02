{- |
第3章 イミュータブルな値
-}
module Ch03_SlicingAndAppending(module Ch03_SlicingAndAppending) where

-- 3.19 実習：イミュータブルなスライスとアペンド

firstTwo :: [a] -> [a]
firstTwo = take 2

lastTwo :: [a] -> [a]
lastTwo list = drop (length list - 2) list

movedFirstTwoToTheEnd :: [a] -> [a]
movedFirstTwoToTheEnd list = afterFirstTwo ++ firstTwo'
  where
    (firstTwo', afterFirstTwo) = splitAt 2 list

insertedBeforeLast :: [a] -> a -> [a]
insertedBeforeLast list element = beforeLast ++ element : last'
  where
    (beforeLast, last') = splitAt (length list - 1) list
