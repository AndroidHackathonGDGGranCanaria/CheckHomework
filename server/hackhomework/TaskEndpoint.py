import json
import webapp2
from ResponseBuilder import ResponseBuilder


class TaskEndpoint(webapp2.RequestHandler):
    def get(self):
        self.response.content_type = 'application/json'
        parentID = self.request.get('parentID')
        json.dump(ResponseBuilder(parentID).build(), self.response.out)