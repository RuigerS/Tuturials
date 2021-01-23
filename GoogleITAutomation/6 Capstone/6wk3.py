#!/usr/bin/env python3

import json
import locale
import sys
import reports
import emails


from reportlab.platypus import SimpleDocTemplate
from reportlab.platypus import Paragraph, Spacer, Table, Image
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib import colors

def load_data(filename):
  """Loads the contents of filename as a JSON file."""
  with open(filename) as json_file:
    data = json.load(json_file)
  return data


def format_car(car):
  """Given a car dictionary, returns a nicely formatted name."""
  return "{} {} ({})".format(
      car["car_make"], car["car_model"], car["car_year"])


def process_data(data):
  """Analyzes the data, looking for maximums.

  Returns a list of lines that summarize the information.
  """
  max_revenue = {"revenue": 0}
  most_sales = {"total_sales": 0}
  years={}
  for item in data:
    # Calculate the revenue generated by this model (price * total_sales)
    # We need to convert the price from "$1234.56" to 1234.56
    item_price = locale.atof(item["price"].strip("$"))
    item_revenue = item["total_sales"] * item_price
    if item_revenue > max_revenue["revenue"]:
      item["revenue"] = item_revenue
      max_revenue = item
    # TODO: also handle max sales
    item_sales=item["total_sales"]
    if item_sales>most_sales["total_sales"]:
      most_sales=item
    # TODO: also handle most popular car_year
    years[item["car"]["car_year"]]=years.get(item["car"]["car_year"],0)+item["total_sales"]
  popyear=0
  popsales=0
  for year,sale in years.items():
    if sale>popsales:
      popsales=sale
      popyear=year
  summary = [
    "The {} generated the most revenue: ${}".format(
      format_car(max_revenue["car"]), max_revenue["revenue"]),
    "The {} had the most sales: {}".format(
      format_car(most_sales["car"]),most_sales["total_sales"]),
    "The most popular year was {} with {} sales.".format(popyear,popsales),
  ]

  return summary


def cars_dict_to_table(car_data):
  """Turns the data in car_data into a list of lists."""
  table_data = [["ID", "Car", "Price", "Total Sales"]]
  for item in car_data:
    table_data.append([item["id"], format_car(item["car"]), item["price"], item["total_sales"]])
  return table_data


def main(argv):
  """Process the JSON data and generate a full report out of it."""
  data = load_data("car_sales.json")
  summary = process_data(data)
  print(summary)
  # TODO: turn this into a PDF report
  table_raw = table[1:]
  table_sorted = sorted(table_raw, key=lambda x:x[1], reverse=False)
  #adding the header back to the table
  table_sorted.insert(0, ["ID", "Car", "Price", "Total Sales"])
  report_summary = summary[0] + "<br/>" + summary[1] + "<br/>" + summary[2] + "<br/>"
  reports.generate("/tmp/cars.pdf", "Title", report_summary , table_sorted) 
  # TODO: send the PDF report as an email attachment
  sender = "automation@example.com"
  receiver = "me@example.com"
  subject = "Sales summary for last month"
  body = summary[0] + "\n" + summary[1] + "\n" + summary[2] + "\n"
  package = "/tmp/cars.pdf"
  message = emails.generate(sender, receiver, subject, body, package)
  emails.send(message)


if __name__ == "__main__":
  main(sys.argv)

