{- |
第2章 純粋関数
-}
module Ch02_TestingPureFunctions(module Ch02_TestingPureFunctions) where

-- 2.21 コーヒーブレイク：純粋関数のテスト

add :: Num a => a -> a -> a
add = (+)

getFirstCharacter :: String -> Char
getFirstCharacter []    = ' '
getFirstCharacter (c:_) = c
