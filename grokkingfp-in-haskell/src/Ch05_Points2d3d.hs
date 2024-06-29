{- |
第5章 逐次プログラム
-}
module Ch05_Points2d3d(module Ch05_Points2d3d) where

-- 5.12 実習：入れ子のflatMap

data Point = Point { x :: !Int, y :: !Int } deriving (Show, Eq)

-- 5.15 コーヒーブレイク：flatMapとfor内包表記

data Point3d = Point3d { x3d :: !Int, y3d :: !Int, z3d :: !Int } deriving (Show, Eq)
