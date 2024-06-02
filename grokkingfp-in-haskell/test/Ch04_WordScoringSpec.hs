module Ch04_WordScoringSpec(spec) where

import           Test.Hspec

import qualified Ch04_PassingFunctions as PF
import qualified Ch04_WordScoring      as Sut

spec :: Spec
spec = do
  describe "rankedWords" $ do
    let words' = ["ada", "haskell", "scala", "java", "rust"]
    it "sorts by score" $ do
      Sut.rankedWords Sut.score words' `shouldBe` ["haskell", "rust", "scala", "java", "ada"]
    it "sorts by score and bonus" $ do
      Sut.rankedWords (\w -> Sut.score w + Sut.bonus w) words' `shouldBe` ["scala", "haskell", "rust", "java", "ada"]
    it "sorts by score, bonus and penalty" $ do
      Sut.rankedWords (\w -> Sut.score w + Sut.bonus w - Sut.penalty w) words' `shouldBe` ["java", "scala", "ada", "haskell", "rust"]

  -- 4.28 実習：map
  describe "map" $ do
    it "maps" $ do
      map PF.len ["scala", "rust", "ada"] `shouldBe` [5, 4, 3]
      map PF.numberOfS ["rust", "ada"] `shouldBe` [1, 0]
      map PF.negative [5, 1, 2, 4, 0] `shouldBe` ([-5, -1, -2, -4, 0] :: [Int])
      map (2 *) [5, 1, 2, 4, 0] `shouldBe` ([10, 2, 4, 8, 0] :: [Int])

  -- 4.33 実習：filter
  describe "filter" $ do
    it "filters" $ do
      filter (\w -> PF.len w < 5) ["scala", "rust", "ada"] `shouldBe` ["rust", "ada"]
      filter (\w -> PF.numberOfS w >= 3) ["rust", "ada"] `shouldBe` []
      filter odd [5, 1, 2, 4, 0] `shouldBe` ([5, 1] :: [Int])
      filter (> 4) [5, 1, 2, 4, 0] `shouldBe` ([5] :: [Int])
