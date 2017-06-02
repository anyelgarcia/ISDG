// Diego Movilla Gayoso (1ºI)
//DNI 50247938E
#include <iostream>
#include <iomanip>
using namespace std;
#include <string>
#include <fstream>

const int N_STK = 10;
const string File_Name = "stocks.txt";
const string Second_File = "week.txt";

typedef struct {
	string name;
	double price;
	int shares;
}tItem;
typedef tItem tStockList[N_STK];

bool load(tStockList stocklist);
void display(const tStockList stocklist);
void process(tStockList stocklist);
int findCompany(const tStockList stocklist, string name);
void save(const tStockList stocklist);
double sumOfPrice(const tStockList stocklist);
void UpdatePortfoliosValue(tStockList stocklist, string name, char operation, double quantity); //Added functionality

int main() {
	tItem item;
	tStockList stocklist;

	if (!load(stocklist)){
		cerr << "Sorry, loading process failed!";
	}
	else {
		display(stocklist); // portfolio displayed on the screen.(With total value).
		process(stocklist); //read operation from "week.txt".
		save(stocklist); // updated portfolio will be displayed and saved on "stocks.txt".
	}
	system("pause");
	return 0;
}

bool load(tStockList stocklist){
	bool ok = false;
	int i = 0;
	tItem item;
	ifstream file;
	file.open(File_Name.c_str());

	if (!file.is_open()){
		cerr << "Sorry men, an error ocurred while loading the file!";
		ok = false;
	}
	else{
		file >> item.name;
		while ((item.name != "#") && (i < N_STK)){
			file >> item.price >> item.shares;
			stocklist[i] = item;
			i++;
			ok = true;
			file >> item.name;
		}
		file.close();
		if (i >= N_STK){
			ok = false;
		}

	}
	return ok;
}

double sumOfPrice(const tStockList stocklist){
	double sum = 0, price = 0;
	int units = 0;
	for (int i = 0; i < N_STK; i++){
		price = price + stocklist[i].price;
		units = units + stocklist[i].shares;
		sum = price * units;
	}
	return sum;
}

void display(const tStockList stocklist){
	double sum = sumOfPrice(stocklist);
	for (int i = 0; i < N_STK; i++){
		cout << stocklist[i].name << right << setw(15) << stocklist[i].shares << setw(10) << stocklist[i].price << endl;
	}
	cout << "Total value: " << "$" << sum;
}
void process(tStockList stocklist){
	string name; 
	char operation;
	double quantity;
	ifstream file; // read operation from the file "week.txt"
	int index;
	file.open(Second_File.c_str());

	if (!file.is_open()){
		cerr << "Could not opened 'Week.txt'";
	}
	else {
		while (operation != 'X'){
			file >> operation >> name >> quantity;
			index = findCompany(stocklist, name);
			if (index = -1){
				cout << operation << " " << name << " " << quantity << " " << "Error: Company not found!";
			}
			else {
				if ((operation == 'S') && (quantity > stocklist[index].shares)) {
					cout << operation << " " << name << " " << quantity << " " << "Error: Not enough shares!";
				}
				else {
					cout << operation << " " << name << " " << quantity << " " << "OK" << endl;
				}
			}
		}
		file.close();
	}
}
int findCompany(const tStockList stocklist, string name){
	int i = 0;
	bool found = false;

	while ((!found) && (i < N_STK)){
		if (stocklist[i].name == name){
			found = true;
		}
		else {
			found = false;
			i++;
		}
	}
	if (!found){
		i = -1;
	}
	return i;
}
void save(const tStockList stocklist) {
	ofstream file;
	file.open(File_Name.c_str());

	if (file.is_open()){
		for (int i = 0; i < N_STK; i++){
			file << stocklist[i].name << right << setw(15) << stocklist[i].shares << setw(10) << "$" << stocklist[i].price << endl;
		}
		
		file.close();
	}
	else{
		cerr << "Could not opened the file in order to save information";
	}

}
void UpdatePortfoliosValue(tStockList stocklist, string name, char operation, double quantity){
	int i = findCompany(stocklist, name);
	int finalShare;
	if ((operation == 'S') && (quantity <= stocklist[i].shares)){
		finalShare = stocklist[i].shares + quantity;
	}
	if (operation == 'B') {
		finalShare = stocklist[i].shares - quantity;
	}
	if (operation == 'P'){
		stocklist[i].price = quantity;
	}

}
