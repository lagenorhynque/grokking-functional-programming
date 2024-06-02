module Ch03_AbbreviateNamesSpec(spec) where

import           Test.Hspec

import qualified Ch03_AbbreviateNames as Sut

spec :: Spec
spec = do
  describe "abbreviate" $ do
    it "abbreviates a name" $ do
      Sut.abbreviate "Alonzo Church" `shouldBe` "A. Church"
      Sut.abbreviate "A. Church" `shouldBe` "A. Church"
      Sut.abbreviate "A Church" `shouldBe` "A. Church"
