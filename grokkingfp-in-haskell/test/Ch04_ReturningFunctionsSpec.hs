module Ch04_ReturningFunctionsSpec(spec) where

import           Test.Hspec

import qualified Ch04_ReturningFunctions as Sut

spec :: Spec
spec = do
  describe "largerThan" $ do
    it "returns a function that checks if a number is larger than the given number" $ do
      filter (Sut.largerThan 4) [5, 1, 2, 4, 0] `shouldBe` [5]
      filter (Sut.largerThan 1) [5, 1, 2, 4, 0] `shouldBe` [5, 2, 4]

  describe "divisibleBy" $ do
    it "returns a function that checks if a number is divisible by the given number" $ do
      filter (Sut.divisibleBy 5) [5, 1, 2, 4, 15] `shouldBe` [5, 15]
      filter (Sut.divisibleBy 2) [5, 1, 2, 4, 15] `shouldBe` [2, 4]

  describe "shroterThan" $ do
    it "returns a function that checks if a string is shorter than the given number" $ do
      filter (Sut.shroterThan 4) ["scala", "ada"] `shouldBe` ["ada"]
      filter (Sut.shroterThan 7) ["scala", "ada"] `shouldBe` ["scala", "ada"]

  describe "containsS" $ do
    it "returns a function that checks if a string contains more than the given number of 's'" $ do
      filter (Sut.containsS 2) ["rust", "ada"] `shouldBe` []
      filter (Sut.containsS 0) ["rust", "ada"] `shouldBe` ["rust"]
