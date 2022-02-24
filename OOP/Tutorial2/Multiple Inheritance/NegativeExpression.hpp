#include "Expression.hpp"

class NegativeExpression:public UnaryExpression
{
private:
    /* data */
public:
    NegativeExpression(Expression *x);
    int solve();  
};
