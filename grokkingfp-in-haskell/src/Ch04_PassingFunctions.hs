{- |
第4章 値としての関数
-}
module Ch04_PassingFunctions(module Ch04_PassingFunctions) where


-- 4.17 実習：関数を渡す

len :: String -> Int
len = length

numberOfS :: String -> Int
numberOfS = length . filter (== 's')

negative :: Num a => a -> a
negative = negate

negativeNumberOfS :: String -> Int
negativeNumberOfS = negative . numberOfS
