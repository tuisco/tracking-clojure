(ns mark-tracking-clojure.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.response :as response]))

(def img (slurp "./img.gif"))

(defroutes app-routes
  (GET "/reevoomark/track/miss" { { 
      sku :sku,
      retailer_id :retailer_id,
      badge_type :badge_type,
      badge_variant :badge_variant } :params } img)

  (GET "/reevoomark/track/impression" {{ 
      sku :sku,
      retailer_id :retailer_id,
      badge_type :badge_type,
      badge_variant :badge_variant } :params } img)

  (GET "/reevoomark/track/non_impression" {{ 
      sku :sku,
      retailer_id :retailer_id,
      badge_type :badge_type,
      badge_variant :badge_variant } :params } img)
  
  
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
