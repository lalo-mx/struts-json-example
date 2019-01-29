<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype>
<html>
    <head>
        <title>Consuming JSON request</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/dojo/1.14.1/dojo/dojo.js"></script>
        <script type="application/javascript">
            require([
                'dojo/_base/lang', 'dojo/Deferred',  'dojo/rpc/JsonService', 'dojo/domReady!'
            ],
            function (
                lang, Deferred, jsonServ
            ) {
            var responseDom = $("#response");
            function invokeMethod(args) {
                var def = new Deferred();
                try {
                    var serv = jsonServ(args.url);
                    serv.strictArgChecks = false;
                    serv.generateMethod(args.method, args.params || [], args.url).apply(serv, args.params || []).then(
                        function(r) {
                            def.resolve(r);
                        });
                } catch (e) {
                    def.reject(e);
                }
                return def.promise;
            }
            function consume(name, i, j) {
                return invokeMethod({
                    url: name + '.action',
                    params: [i],
                    method:'consume' + j
                }).then(function(response){
                    responseDom.append(JSON.stringify(response));
                });
            }
            function executeRequests(calls) {
              for(var i = 0; i < calls; i++) { 
                  for(var j = 0; j < 10; j++) { 
                      consume('consume'+j, i, j);
                  }
              }
            }
            executeRequests(100);
          });
        </script>
    </head>

    <body>
        <form>
        </form>
        <textarea rows="20" cols="60" id="response"></textarea>
    </body>
</html>