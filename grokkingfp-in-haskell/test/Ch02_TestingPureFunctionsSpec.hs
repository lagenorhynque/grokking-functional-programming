{- |
第2章 純粋関数
-}
module Ch02_TestingPureFunctionsSpec(spec) where

import           Test.Hspec

import qualified Ch01_Intro                as Intro
import qualified Ch02_TestingPureFunctions as TPF
import qualified Ch02_TipCalculator        as TipCalculator

-- 2.21 コーヒーブレイク：純粋関数のテスト

spec :: Spec
spec = do
  describe "increment" $ do
    it "increments a number" $ do
      Intro.increment 0 `shouldBe` (1 :: Int)
      Intro.increment (-1) `shouldBe` (0 :: Int)
      Intro.increment 2 `shouldBe` (3 :: Int)
      Intro.increment (-3) `shouldBe` (-2 :: Int)

  describe "add" $ do
    it "adds two numbers" $ do
      TPF.add 1 2 `shouldBe` (3 :: Int)
      TPF.add 0 0 `shouldBe` (0 :: Int)
      TPF.add 1 (-2) `shouldBe` (-1 :: Int)
      TPF.add (-1) 2 `shouldBe` (1 :: Int)

  describe "wordScore" $ do
    it "calculates the score of a word" $ do
      Intro.wordScore "Scala" `shouldBe` 3
      Intro.wordScore "Clojure" `shouldBe` 7
      Intro.wordScore "Haskell" `shouldBe` 6
      Intro.wordScore "" `shouldBe` 0

  describe "getTipPercentage" $ do
    it "gets the tip percentage" $ do
      TipCalculator.getTipPercentage [] `shouldBe` 0
      TipCalculator.getTipPercentage ["Alice", "Bob", "Charlie", "David", "Eve"] `shouldBe` 10
      TipCalculator.getTipPercentage ["Alice", "Bob", "Charlie", "David", "Eve", "Frank"] `shouldBe` 20

  describe "getFirstCharacter" $ do
    it "gets the first character of a string" $ do
      TPF.getFirstCharacter "Scala" `shouldBe` 'S'
      TPF.getFirstCharacter "Clojure" `shouldBe` 'C'
      TPF.getFirstCharacter "Haskell" `shouldBe` 'H'
      TPF.getFirstCharacter "" `shouldBe` ' '
