import json
import subprocess

# Load the JSON data from a file
with open('data.json', 'r', encoding='utf-8') as file:
    data = json.load(file)

# Loop through each entry in the JSON data
for item in data:
    print(f"Processing item {item['id']} {item['name']}")
    # Calculate the workerIncome as 40% of the price and round to 2 decimal places
    calculated_income = round(item['price'] * 0.4, 2)

    # Prepare the JSON data to be sent in the curl request
    json_data = {
        "op": "replace",
        "workerIncome": calculated_income
    }

    # Convert the JSON data to a string format
    json_str = json.dumps(json_data)

    # Create the curl command as a list (to avoid shell=True)
    curl_command = [
        'curl', '--location', '--request', 'PATCH',
        f"http://income-calculator:8080/procedures/{item['id']}",
        '--header', 'Content-Type: application/json',
        '--data', json_str
    ]

    # Execute the curl command
    result = subprocess.run(curl_command, capture_output=True, text=True)

    # Print the result
    print(f"Response for {item['id']}:")
    print(result.stdout)
    print(result.stderr)
