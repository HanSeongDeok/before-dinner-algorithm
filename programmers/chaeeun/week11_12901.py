from datetime import date
import calendar

def solution(a, b):
    day = date(2016, a, b).weekday()
    return calendar.day_name[day][:3].upper()
