module Ch05_PointsInsideCirclesSpec(spec) where

import           Control.Monad            (guard)
import           Test.Hspec

import qualified Ch05_Points2d3d          as Points2d3d
import qualified Ch05_PointsInsideCircles as Sut

spec :: Spec
spec = do
  describe "isInside" $ do
    it "checks if a point is inside a circle" $ do
      let points = [Points2d3d.Point 5 2, Points2d3d.Point 1 1]
          riskyRadiuses = [-10, 0, 2] :: [Int]
      [show point ++ " is within a radius of " ++ show r
        | r <- filter (> 0) riskyRadiuses,
          point <-  filter (\p -> Sut.isInside p r) points] `shouldBe` ["Point {x = 1, y = 1} is within a radius of 2"]
      (do
          r <- filter (> 0) riskyRadiuses
          point <- filter (\p -> Sut.isInside p r) points
          return $ show point ++ " is within a radius of " ++ show r) `shouldBe` ["Point {x = 1, y = 1} is within a radius of 2"]
      [show point ++ " is within a radius of " ++ show r
        | r <- riskyRadiuses,
          point <- points,
          r > 0,
          Sut.isInside point r] `shouldBe` ["Point {x = 1, y = 1} is within a radius of 2"]
      (do
         r <- riskyRadiuses
         guard $ r > 0
         point <- points
         guard $ Sut.isInside point r
         return $ show point ++ " is within a radius of " ++ show r) `shouldBe` ["Point {x = 1, y = 1} is within a radius of 2"]
      [show inPoint ++ " is within a radius of " ++ show validRadius
        | r <- riskyRadiuses,
          validRadius <- Sut.validateRadius r,
          point <- points,
          inPoint <- Sut.insideFilter point validRadius] `shouldBe` ["Point {x = 1, y = 1} is within a radius of 2"]
      (do
         r <- riskyRadiuses
         validRadius <- Sut.validateRadius r
         point <- points
         inPoint <- Sut.insideFilter point validRadius
         return $ show inPoint ++ " is within a radius of " ++ show validRadius) `shouldBe` ["Point {x = 1, y = 1} is within a radius of 2"]
