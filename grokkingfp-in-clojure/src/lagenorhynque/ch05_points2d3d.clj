(ns lagenorhynque.ch05-points2d3d
  "第5章 逐次プログラム"
  (:require
   [clojure.spec.alpha :as s]))

;; 5.12 実習：入れ子のflatMap

(s/def ::x number?)
(s/def ::y number?)
(s/def ::point (s/keys :req-un [::x ::y]))

(defrecord Point [x y])

;; 5.15 コーヒーブレイク：flatMapとfor内包表記

(s/def ::z number?)
(s/def ::point3d (s/keys :req-un [::x ::y ::z]))

(defrecord Point3d [x y z])
