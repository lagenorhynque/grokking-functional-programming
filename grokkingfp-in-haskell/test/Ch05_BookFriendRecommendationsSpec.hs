module Ch05_BookFriendRecommendationsSpec(spec) where

import           Test.Hspec

import qualified Ch05_BookFriendRecommendations as Sut

-- 5.7 コーヒーブレイク：リストのリストを処理する

spec :: Spec
spec = do
  describe "recommendedBooks" $ do
    let friends = ["Alice", "Bob", "Grace"]
        recommendations = friends >>= Sut.recommendedBooks
        authors = recommendations >>= Sut.authors
    it "recommendations" $ do
      recommendations `shouldBe` [Sut.Book "FP in Scala" ["Chiusano", "Bjarnason"],
                                  Sut.Book "Get Programming with Scala" ["Sfregola"],
                                  Sut.Book "Harry Potter" ["Rowling"],
                                  Sut.Book "The Lord of the Rings" ["Tolkien"]]
    it "authors" $ do
      authors `shouldBe` ["Chiusano", "Bjarnason", "Sfregola", "Rowling", "Tolkien"]
