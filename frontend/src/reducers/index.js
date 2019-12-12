import {combineReducers} from 'redux'
import errorReducer from './errorReducer'
import projcectReducer from './projcectReducer'
import backlogReducer from './backlogReducer'
export default combineReducers({
    errors:errorReducer, 
    project:projcectReducer,
    backlog:backlogReducer
})