module Ch05_Points2d3dSpec(spec) where

import           Test.Hspec

import qualified Ch05_Points2d3d as Sut

spec :: Spec
spec = do
  describe "Point" $ do
    -- 5.12 実習：入れ子のflatMap
    it "can be generated from lists" $ do
      ([1] >>= \x ->
         [-2, 7] >>= \y ->
            return $ Sut.Point x y) `shouldBe` [Sut.Point 1 (-2), Sut.Point 1 7]
      length ([1] >>= \x ->
                [-2, 7, 10] >>= \y ->
                  return $ Sut.Point x y) `shouldBe` 3
      length ([1, 2] >>= \x ->
                [-2, 7] >>= \y ->
                  return $ Sut.Point x y) `shouldBe` 4
      length ([1, 2] >>= \x ->
                [-2, 7, 10] >>= \y ->
                  return $ Sut.Point x y) `shouldBe` 6
      length ([] >>= \x ->
                [-2, 7] >>= \y ->
                  return $ Sut.Point x y) `shouldBe` 0
      length ([1] >>= \x ->
                [] >>= \y ->
                  return $ Sut.Point x y) `shouldBe` 0

      -- 5.15 コーヒーブレイク：flatMapとfor内包表記
      let xs = [1]
          ys = [-2, 7]
      [Sut.Point x y | x <- xs,
                       y <- ys] `shouldBe` [Sut.Point 1 (-2), Sut.Point 1 7]
      (do
         x <- xs
         y <- ys
         return $ Sut.Point x y) `shouldBe` [Sut.Point 1 (-2), Sut.Point 1 7]

  describe "Point3d" $ do
    it "can be generated from lists" $ do
      let xs = [1]
          ys = [-2, 7]
          zs = [3, 4]
      [Sut.Point3d x y z | x <- xs,
                           y <- ys,
                           z <- zs] `shouldBe` [Sut.Point3d 1 (-2) 3, Sut.Point3d 1 (-2) 4, Sut.Point3d 1 7 3, Sut.Point3d 1 7 4]
      (do
         x <- xs
         y <- ys
         z <- zs
         return $ Sut.Point3d x y z) `shouldBe` [Sut.Point3d 1 (-2) 3, Sut.Point3d 1 (-2) 4, Sut.Point3d 1 7 3, Sut.Point3d 1 7 4]
      (xs >>= \x ->
         ys >>= \y ->
           zs >>= \z ->
             return $ Sut.Point3d x y z) `shouldBe` [Sut.Point3d 1 (-2) 3, Sut.Point3d 1 (-2) 4, Sut.Point3d 1 7 3, Sut.Point3d 1 7 4]
