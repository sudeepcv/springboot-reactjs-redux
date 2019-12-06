import {combineReducers} from 'redux'
import errorReducer from './errorReducer'
import projcectReducer from './projcectReducer'
export default combineReducers({
    errors:errorReducer, 
    project:projcectReducer
})