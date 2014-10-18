class ResponseBuilder(object):
    def __init__(self, parentID):
        self.parentID = parentID

    def build(self):
        if self.parentID == "parentID1":
            return {"tasks": [
                {"id": "1",
                 "subject": "IS2",
                 "limitdate": "2014-12-31",
                 "description": "Happy new Year pg 1",
                 "sonid": "11"}]}

        return {"tasks": [
            {"id": "1",
             "subject": "IS2",
             "limitdate": "2014-12-31",
             "description": "Happy new Year pg 1",
             "sonid": "11"},

            {"id": "2",
             "subject": "SSR",
             "limitdate": "2015-06-01",
             "description": "leer el RFC 2616",
             "sonid": "11"}]}