module Ch04_PassingFunctionsSpec(spec) where

import           Data.List             (sortOn)
import           Test.Hspec

import qualified Ch04_PassingFunctions as Sut

spec :: Spec
spec = do
  describe "sort by len" $ do
    it "sorts by length" $ do
      sortOn Sut.len ["scala", "rust", "ada"] `shouldBe` ["ada", "rust", "scala"]

  describe "sort by numberOfS" $ do
    it "sorts by number of 's'" $ do
      sortOn Sut.numberOfS ["rust", "ada"] `shouldBe` ["ada", "rust"]

  describe "sort by negative" $ do
    it "sorts by negative" $ do
      sortOn Sut.negative [5, 1, 2, 4, 3] `shouldBe` ([5, 4, 3, 2, 1] :: [Int])

  describe "sort by negativeNumberOfS" $ do
    it "sorts by negative number of 's'" $ do
      sortOn Sut.negativeNumberOfS ["ada", "rust"] `shouldBe` ["rust", "ada"]
