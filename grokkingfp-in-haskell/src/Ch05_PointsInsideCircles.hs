{- |
第5章 逐次プログラム
-}
module Ch05_PointsInsideCircles(module Ch05_PointsInsideCircles) where

import qualified Ch05_Points2d3d as Points2d3d

-- 5.23 コーヒーブレイク：フィルタリングの方法

isInside :: Points2d3d.Point -> Int -> Bool
isInside (Points2d3d.Point x y) radius = radius * radius >= x * x + y * y

insideFilter :: Points2d3d.Point -> Int -> [Points2d3d.Point]
insideFilter point radius = if isInside point radius then [point] else []

validateRadius :: Int -> [Int]
validateRadius radius = if radius > 0 then [radius] else []
