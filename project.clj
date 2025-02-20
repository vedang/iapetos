(defproject clj-commons/iapetos (or (System/getenv "PROJECT_VERSION") "0.1.12")
  :description "A Clojure Prometheus Client"
  :url "https://github.com/clj-commons/iapetos"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"
            :year 2019
            :key "mit"}
  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :username :env/clojars_username
                                    :password :env/clojars_password
                                    :sign-releases true}]]

  :dependencies [[org.clojure/clojure "1.11.1" :scope "provided"]
                 [io.prometheus/simpleclient "0.16.0"]
                 [io.prometheus/simpleclient_common "0.16.0"]
                 [io.prometheus/simpleclient_pushgateway "0.16.0"]
                 [io.prometheus/simpleclient_hotspot "0.16.0" :scope "provided"]]
  :profiles {:dev
             {:dependencies [[org.clojure/test.check "1.1.1"]
                             [aleph "0.4.6"]
                             [jmh-clojure "0.4.1"]]
              :source-paths ["dev"]
              :global-vars {*warn-on-reflection* true}}
             :codox
             {:plugins [[lein-codox "0.10.8"]]
              :dependencies [[codox-theme-rdash "0.1.2"]]
              :codox {:project {:name "iapetos"}
                      :metadata {:doc/format :markdown}
                      :themes [:rdash]
                      :source-uri "https://github.com/clj-commons/iapetos/blob/v{version}/{filepath}#L{line}"
                      :namespaces [iapetos.core
                                   iapetos.export
                                   iapetos.standalone
                                   #"^iapetos\.collector\..+"]}}
             :coverage
             {:plugins [[lein-cloverage "1.2.4"]]
              :pedantic? :warn
              :dependencies [[org.clojure/tools.reader "1.3.7"]
                             [riddley "0.2.0"]]}}
  :aliases {"codox" ["with-profile" "+codox" "codox"]
            "codecov" ["with-profile" "+coverage" "cloverage" "--codecov"]}
  :pedantic? :abort)
