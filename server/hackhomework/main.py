#!/usr/bin/env python

import webapp2

from TaskEndpoint import TaskEndpoint


app = webapp2.WSGIApplication([('/api/task', TaskEndpoint)], debug=True)