{- |
第5章 逐次プログラム
-}
module Ch05_Events(module Ch05_Events) where

-- 5.34 コーヒーブレイク：Optionによる解析

data Event = Event { name :: !String, start :: !Int, end :: !Int } deriving (Show, Eq)

validateName :: String -> Maybe String
validateName name' = if not (null name') then Just name' else Nothing

validateEnd :: Int -> Maybe Int
validateEnd end' = if end' < 3000 then Just end' else Nothing

validateStart :: Int -> Int -> Maybe Int
validateStart start' end' = if start' <= end' then Just start' else Nothing

validateLength :: Int -> Int -> Int -> Maybe Int
validateLength start' end' minLength = if end' - start' >= minLength then Just (end' - start') else Nothing

parseLongEvent :: String -> Int -> Int -> Int -> Maybe Event
parseLongEvent name' start' end' minLength = do
  validName <- validateName name'
  validEnd <- validateEnd end'
  validStart <- validateStart start' end'
  _ <- validateLength start' end' minLength
  return $ Event validName validStart validEnd
