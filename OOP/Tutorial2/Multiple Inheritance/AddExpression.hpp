#include "Expression.hpp"

class AddExpression : public BinaryExpression
{
private:
public:
    AddExpression(Expression *x, Expression *y);
    int solve();
};