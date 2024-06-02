module Ch03_SlicingAndAppendingSpec(spec) where

import           Test.Hspec

import qualified Ch03_SlicingAndAppending as Sut

spec :: Spec
spec = do
  describe "firstTwo" $ do
    it "returns the first two elements of a list" $ do
      Sut.firstTwo ["a", "b", "c"] `shouldBe` ["a", "b"]

  describe "lastTwo" $ do
    it "returns the last two elements of a list" $ do
      Sut.lastTwo ["a", "b", "c"] `shouldBe` ["b", "c"]

  describe "movedFirstTwoToTheEnd" $ do
    it "moves the first two elements to the end of a list" $ do
      Sut.movedFirstTwoToTheEnd ["a", "b", "c"] `shouldBe` ["c", "a", "b"]

  describe "insertedBeforeLast" $ do
    it "inserts an element before the last element of a list" $ do
      Sut.insertedBeforeLast ["a", "b"] "c" `shouldBe` ["a", "c", "b"]
