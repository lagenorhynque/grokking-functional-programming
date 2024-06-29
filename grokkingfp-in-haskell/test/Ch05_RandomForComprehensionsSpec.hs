module Ch05_RandomForComprehensionsSpec(spec) where

import qualified Data.Set as S
import           Test.Hspec

spec :: Spec
spec = do
  describe "for comprehension" $ do
    it "works" $ do
      let ys = S.fromList [1]
      [x * y | x <- [1, 2, 3], y <- S.toList ys] `shouldBe` ([1, 2, 3] :: [Int])
      (do
         x <- [1, 2, 3]
         y <- S.toList ys
         return $ x * y) `shouldBe` ([1, 2, 3] :: [Int])
      let xs = S.fromList [1 ,2, 3]
      S.fromList [x * y | x <- S.toList xs, y <- [1]] `shouldBe` (S.fromList [1, 2, 3] :: S.Set Int)
      S.fromList (do
        x <- S.toList xs
        y <- [1]
        return $ x * y) `shouldBe` (S.fromList [1, 2, 3] :: S.Set Int)
      let ys' = S.fromList [1]
          zs = S.fromList [0]
      [x * y * z | x <- [1, 2, 3], y <- S.toList ys', z <- S.toList zs] `shouldBe` ([0, 0 , 0] :: [Int])
      (do
         x <- [1, 2, 3]
         y <- S.toList ys'
         z <- S.toList zs
         return $ x * y * z) `shouldBe` ([0, 0, 0] :: [Int])
