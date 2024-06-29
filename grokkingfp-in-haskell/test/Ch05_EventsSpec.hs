module Ch05_EventsSpec(spec) where

import           Test.Hspec

import qualified Ch05_Events as Sut

spec :: Spec
spec = do
  describe "parseLongEvent" $ do
    it "parses a long event" $ do
      Sut.parseLongEvent "Apollo Program" 1961 1972 10 `shouldBe` Just (Sut.Event "Apollo Program" 1961 1972)
      Sut.parseLongEvent "World War II" 1939 1945 10 `shouldBe` Nothing
      Sut.parseLongEvent "" 1939 1945 10 `shouldBe` Nothing
      Sut.parseLongEvent "Apollo Program" 1972 1961 10 `shouldBe` Nothing
